package no.fint.test.model

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.util.ISO8601DateFormat
import groovy.json.JsonSlurper
import no.fint.model.felles.kompleksedatatyper.Identifikator
import no.fint.model.felles.kompleksedatatyper.Periode
import no.fint.model.resource.Link
import no.fint.model.resource.utdanning.elev.BasisgruppeResource
import no.fint.model.utdanning.elev.Basisgruppe
import no.fint.model.utdanning.elev.Medlemskap
import spock.lang.Specification

import java.util.concurrent.TimeUnit

class ModelSerializationSpec extends Specification {
    def objectMapper
    def jsonSlurper

    void setup() {
        objectMapper = new ObjectMapper()
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
        objectMapper.setDateFormat(new ISO8601DateFormat());
        jsonSlurper = new JsonSlurper()
    }

    def "Serialize Basisgruppe without Links"() {
        given:
        def basisgruppe = new Basisgruppe(
                systemId: new Identifikator(identifikatorverdi: "ABC123"),
                periode: [new Periode(start: new Date(), slutt: new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(365)))],
                beskrivelse: "Basisgruppe 123",
                navn: "ABC123"
        )

        when:
        def result = objectMapper.writeValueAsString(basisgruppe)
        println(result)
        def object = jsonSlurper.parseText(result)

        then:
        object
        object.periode.start
    }

    def "Serialize BasisgruppeResource with links"() {
        given:
        def basisgruppe = new BasisgruppeResource(
                systemId: new Identifikator(identifikatorverdi: "ABC123"),
                periode: [new Periode(start: new Date(), slutt: new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(365)))],
                beskrivelse: "Basisgruppe 123",
                navn: "ABC123"
        )
        basisgruppe.addMedlemskap(Link.with(Medlemskap.class, "systemid", "123"))

        when:
        def result = objectMapper.writeValueAsString(basisgruppe)
        println(result)
        def object = jsonSlurper.parseText(result)

        then:
        object
        object._links.medlemskap
    }
    
}
