package no.novari.fint.test.model

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException
import no.novari.fint.model.felles.Person
import no.novari.fint.model.resource.felles.KontaktpersonResource
import no.novari.fint.model.resource.felles.PersonResource
import no.novari.fint.model.resource.felles.PersonResources

import spock.lang.Specification

class ModelDeserializationSpec extends Specification {
    def objectMapper

    void setup() {
        objectMapper = new ObjectMapper()
    }

    def "Read Person from person.json"() {
        given:
        def input = getClass().getClassLoader().getResourceAsStream("person.json")

        when:
        def result = objectMapper.readValue(input, Person.class)

        then:
        result
        result.fodselsnummer
        result.fodselsnummer.identifikatorverdi == "12345678901"
        result.navn
        result.navn.fornavn == "Tore"
        result.navn.etternavn == "Test"
        result.fodselsdato
        result.bostedsadresse
        result.bostedsadresse.adresselinje.size() == 1
        result.bostedsadresse.adresselinje[0] == "Storgata 12"
    }

    def "Read PersonResource from person.json"() {
        given:
        def input = getClass().getClassLoader().getResourceAsStream("person.json")

        when:
        def result = objectMapper.readValue(input, PersonResource.class)

        then:
        result
    }

    def "Read Person from personresource.json"() {
        given:
        def input = getClass().getClassLoader().getResourceAsStream("personresource.json")

        when:
        def result = objectMapper.readValue(input, Person.class)

        then:
        thrown(UnrecognizedPropertyException)
    }

    def "Read Person from personresource.json with ObjectMapper config"() {
        given:
        def input = getClass().getClassLoader().getResourceAsStream("personresource.json")
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        when:
        def result = objectMapper.readValue(input, Person.class)

        then:
        result
    }

    def "Read PersonResource from personresource.json"() {
        given:
        def input = getClass().getClassLoader().getResourceAsStream("personresource.json")

        when:
        def result = objectMapper.readValue(input, PersonResource.class)

        then:
        result
        result.links.size() == 3
    }

    def "Read Person from personresourcelinks.json"() {
        given:
        def input = getClass().getClassLoader().getResourceAsStream("personresourcelinks.json")

        when:
        def result = objectMapper.readValue(input, Person.class)

        then:
        thrown(UnrecognizedPropertyException)
    }

    def "Read Person from personresourcelinks.json with ObjectMapper config"() {
        given:
        def input = getClass().getClassLoader().getResourceAsStream("personresourcelinks.json")
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        when:
        def result = objectMapper.readValue(input, Person.class)

        then:
        result
    }

    def "Read PersonResource from personresourcelinks.json"() {
        given:
        def input = getClass().getClassLoader().getResourceAsStream("personresourcelinks.json")

        when:
        def result = objectMapper.readValue(input, PersonResource.class)

        then:
        result
        result.bostedsadresse
        result.postadresse
    }

    def "Read PersonResources from personresourceslinks.json"() {
        given:
        def input = getClass().getClassLoader().getResourceAsStream("personresourceslinks.json")

        when:
        def result = objectMapper.readValue(input, PersonResources.class)

        then:
        result
        result.getTotalItems() == 1
        result.links.self.size() == 1
        result.content[0].bostedsadresse
        result.content[0].postadresse
    }

    def "Read KontaktpersonResource from kontaktpersonresource.json"() {
        given:
        def input = getClass().getClassLoader().getResourceAsStream("kontaktpersonresource.json")

        when:
        def result = objectMapper.readValue(input, KontaktpersonResource)

        then:
        result
        result instanceof KontaktpersonResource
        result.links.size() == 2
    }
}
