package no.novari.fint.test.model

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.util.ISO8601DateFormat
import groovy.json.JsonSlurper
import no.novari.fint.model.felles.kompleksedatatyper.Identifikator
import no.novari.fint.model.resource.Link
import no.novari.fint.model.resource.utdanning.elev.BasisgruppeResource
import no.novari.fint.model.utdanning.elev.Basisgruppe
import no.novari.fint.model.utdanning.elev.Basisgruppemedlemskap
import spock.lang.Specification

class ModelSerializationSpec extends Specification {
    def objectMapper
    def jsonSlurper

    void setup() {
        objectMapper = new ObjectMapper()
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
        objectMapper.setDateFormat(new ISO8601DateFormat());
        jsonSlurper = new JsonSlurper()
    }

    def "Serialize Klasse without Links"() {
        given:
        def klasse = new Basisgruppe(
                systemId: new Identifikator(identifikatorverdi: "ABC123"),
                beskrivelse: "Klasse 123",
                navn: "ABC123"
        )

        when:
        def result = objectMapper.writeValueAsString(klasse)
        println(result)
        def object = jsonSlurper.parseText(result)

        then:
        object
        object.navn == "ABC123"
    }

    def "Serialize KlasseResource with links"() {
        given:
        def klasse = new BasisgruppeResource(
                systemId: new Identifikator(identifikatorverdi: "ABC123"),
                beskrivelse: "Klasse 123",
                navn: "ABC123"
        )
        klasse.addKlassemedlemskap(Link.with(Klassemedlemskap.class, "systemid", "123"))

        when:
        def result = objectMapper.writeValueAsString(klasse)
        println(result)
        def object = jsonSlurper.parseText(result)

        then:
        object
        object._links.klassemedlemskap
    }
    
}
