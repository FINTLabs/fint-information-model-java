package no.fint.test.model

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.json.JsonSlurper
import no.fint.model.felles.Person
import no.fint.model.felles.kompleksedatatyper.Adresse
import no.fint.model.felles.kompleksedatatyper.Identifikator
import no.fint.model.felles.kompleksedatatyper.Personnavn
import no.fint.model.resource.Link
import no.fint.model.resource.felles.KontaktpersonResource
import no.fint.model.resource.felles.PersonResource
import no.fint.model.resource.felles.kompleksedatatyper.AdresseResource
import spock.lang.Specification

class ModelSerializationSpec extends Specification {
    def objectMapper
    def jsonSlurper

    void setup() {
        objectMapper = new ObjectMapper()
        jsonSlurper = new JsonSlurper()
    }

    def "Serialize Person without Links"() {
        given:
        def person = new Person(
                fodselsnummer: new Identifikator(identifikatorverdi: "12345678901"),
                navn: new Personnavn(fornavn: "Tore", etternavn: "Test"),
                fodselsdato: new Date(55, 5, 15),
                bostedsadresse: new Adresse(postnummer: "1234", poststed: "Test", adresselinje: ["Storgata 12"])
        )

        when:
        def result = objectMapper.writeValueAsString(person)
        println(result)
        def object = jsonSlurper.parseText(result)

        then:
        object
        object.bostedsadresse.adresselinje
        object.navn.etternavn
    }

    def "Serialize PersonResource with only own links"() {
        given:
        def person = new PersonResource(
                fodselsnummer: new Identifikator(identifikatorverdi: "12345678901"),
                navn: new Personnavn(fornavn: "Tore", etternavn: "Test"),
                fodselsdato: new Date(55, 5, 15),
                bostedsadresse: new AdresseResource(postnummer: "1234", poststed: "Test", adresselinje: ["Storgata 12"])
        )
        person.addKjonn(Link.with("/felles/kjonn/systemid/1"))
        person.addStatsborgerskap(Link.with("/felles/land/systemid/no"))

        when:
        def result = objectMapper.writeValueAsString(person)
        println(result)
        def object = jsonSlurper.parseText(result)

        then:
        object
        object._links.statsborgerskap
    }

    def "Serialize PersonResource with deep links"() {
        given:
        def person = new PersonResource(
                fodselsnummer: new Identifikator(identifikatorverdi: "12345678901"),
                navn: new Personnavn(fornavn: "Tore", etternavn: "Test"),
                fodselsdato: new Date(55, 5, 15),
                bostedsadresse: new AdresseResource(postnummer: "1234", poststed: "Test", adresselinje: ["Storgata 12"])
        )
        person.addKjonn(new Link(href: "/felles/kjonn/systemid/1"))
        person.addStatsborgerskap(new Link(href: "/felles/land/systemid/no"))

        person.bostedsadresse.addLand(new Link(href: "/felles/land/systemid/no"))

        when:
        def result = objectMapper.writeValueAsString(person)
        println(result)
        def object = jsonSlurper.parseText(result)

        then:
        object
        object.bostedsadresse._links.land
    }

    def "Serialize KontaktpersonResource with links"() {
        given:
        def kontaktperson = new KontaktpersonResource(
                systemId: new Identifikator(identifikatorverdi: "ABCD1234"),
                type: "forelder",
                navn: new Personnavn(fornavn: "Tore", etternavn: "Tang")
        )
        kontaktperson.addKontaktperson(Link.with(Person, "fodselsnummer", "23456789012"))

        when:
        def result = objectMapper.writeValueAsString(kontaktperson)
        def object = jsonSlurper.parseText(result)

        then:
        object
        object.navn.fornavn == "Tore"
        object.navn.etternavn == "Tang"
        object._links.size() == 1
    }
}
