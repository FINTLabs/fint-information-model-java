package no.novari.fint.test.model

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException
import no.novari.fint.model.resource.felles.PersonResource
import no.novari.fint.model.resource.utdanning.elev.KlasseResource
import no.novari.fint.model.utdanning.elev.Klasse
import spock.lang.Specification

class ModelDeserializationSpec extends Specification {
    def objectMapper

    void setup() {
        objectMapper = new ObjectMapper()
    }

    def "Read Klasse from klasse.json"() {
        given:
        def input = getClass().getResourceAsStream("/klasse.json")

        when:
        def result = objectMapper.readValue(input, Klasse.class)
        println(result)

        then:
        result
        result.navn == "ABC123"
    }

    def "Read KlasseResource from klasse.json"() {
        given:
        def input = getClass().getResourceAsStream("/klasse.json")

        when:
        def result = objectMapper.readValue(input, KlasseResource.class)
        println(result)

        then:
        result
        result.navn == "ABC123"
    }

    def "Read Klasse from klasseresource.json"() {
        given:
        def input = getClass().getResourceAsStream("/klasseresource.json")

        when:
        def result = objectMapper.readValue(input, Klasse.class)
        println(result)

        then:
        thrown(UnrecognizedPropertyException)
    }

    def "Read Klasse from klasseresource.json with ObjectMapper config"() {
        given:
        def input = getClass().getResourceAsStream("/klasseresource.json")
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        when:
        def result = objectMapper.readValue(input, Klasse.class)
        println(result)

        then:
        result
        result.navn == "ABC123"
    }

    def "Read KlasseResource from klasseresource.json"() {
        given:
        def input = getClass().getResourceAsStream("/klasseresource.json")

        when:
        def result = objectMapper.readValue(input, KlasseResource.class)
        println(result)

        then:
        result
        result.navn == "ABC123"
        result.links.size() == 2
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
