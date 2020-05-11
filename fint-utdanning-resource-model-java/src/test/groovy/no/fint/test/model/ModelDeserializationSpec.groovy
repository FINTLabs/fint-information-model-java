package no.fint.test.model

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException
import no.fint.model.resource.felles.PersonResource
import no.fint.model.resource.utdanning.elev.BasisgruppeResource
import no.fint.model.utdanning.elev.Basisgruppe
import spock.lang.Specification

class ModelDeserializationSpec extends Specification {
    def objectMapper

    void setup() {
        objectMapper = new ObjectMapper()
    }

    def "Read Basisgruppe from basisgruppe.json"() {
        given:
        def input = getClass().getResourceAsStream("/basisgruppe.json")

        when:
        def result = objectMapper.readValue(input, Basisgruppe.class)
        println(result)

        then:
        result
        result.periode.start
        result.navn == "ABC123"
    }

    def "Read BasisgruppeResource from basisgruppe.json"() {
        given:
        def input = getClass().getResourceAsStream("/basisgruppe.json")

        when:
        def result = objectMapper.readValue(input, BasisgruppeResource.class)
        println(result)

        then:
        result
        result.periode.start
        result.navn == "ABC123"
    }

    def "Read Basisgruppe from basisgrupperesource.json"() {
        given:
        def input = getClass().getResourceAsStream("/basisgrupperesource.json")

        when:
        def result = objectMapper.readValue(input, Basisgruppe.class)
        println(result)

        then:
        thrown(UnrecognizedPropertyException)
    }

    def "Read Basisgruppe from basisgrupperesource.json with ObjectMapper config"() {
        given:
        def input = getClass().getResourceAsStream("/basisgrupperesource.json")
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        when:
        def result = objectMapper.readValue(input, Basisgruppe.class)
        println(result)

        then:
        result
        result.periode.start
        result.navn == "ABC123"
    }

    def "Read BasisgruppeResource from basisgrupperesource.json"() {
        given:
        def input = getClass().getResourceAsStream("/basisgrupperesource.json")

        when:
        def result = objectMapper.readValue(input, BasisgruppeResource.class)
        println(result)

        then:
        result
        result.periode.start
        result.navn == "ABC123"
        result.links.size() == 1
    }

    def 'Empty Person JSON'() {
        given:
        def input = getClass().getResourceAsStream('/person.json')

        when:
        def result = objectMapper.readValue(input, PersonResource.class)
        println(result)

        then:
        result
    }
}
