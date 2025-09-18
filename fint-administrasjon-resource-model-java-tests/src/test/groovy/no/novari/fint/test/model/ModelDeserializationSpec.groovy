package no.novari.fint.test.model

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException
import no.novari.fint.model.administrasjon.personal.Fastlonn
import no.novari.fint.model.resource.administrasjon.personal.FastlonnResource
import no.novari.fint.model.resource.administrasjon.personal.FastlonnResources
import spock.lang.Specification

class ModelDeserializationSpec extends Specification {
    def objectMapper

    void setup() {
        objectMapper = new ObjectMapper()
    }

    def "Read Fastlonn from fastlonn.json"() {
        given:
        def input = getClass().getResourceAsStream("/fastlonn.json")

        when:
        def result = objectMapper.readValue(input, Fastlonn.class)
        println(result)

        then:
        result
        result.anvist
        result.periode.start
        result.systemId.identifikatorverdi == "ABC123"
        result.beskrivelse == "Test"
        result.periode.start
        result.prosent == 10000
        result.kontostreng
    }

    def "Read FastlonnResource from fastlonn.json"() {
        given:
        def input = getClass().getResourceAsStream("/fastlonn.json")

        when:
        def result = objectMapper.readValue(input, FastlonnResource.class)
        println(result)

        then:
        result
        result.anvist
        result.periode.start
        result.systemId.identifikatorverdi == "ABC123"
        result.beskrivelse == "Test"
        result.periode.start
        result.prosent == 10000
        result.kontostreng
    }

    def "Read Fastlonn from fastlonnresource.json"() {
        given:
        def input = getClass().getResourceAsStream("/fastlonnresource.json")

        when:
        def result = objectMapper.readValue(input, Fastlonn.class)
        println(result)

        then:
        thrown(UnrecognizedPropertyException)
    }

    def "Read Fastlonn from fastlonnresource.json with ObjectMapper config"() {
        given:
        def input = getClass().getResourceAsStream("/fastlonnresource.json")
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

        when:
        def result = objectMapper.readValue(input, Fastlonn.class)
        println(result)

        then:
        result
        result.anvist
        result.periode.start
        result.systemId.identifikatorverdi == "ABC123"
        result.beskrivelse == "Test"
        result.periode.start
        result.prosent == 10000
        result.kontostreng
    }

    def "Read FastlonnResource from fastlonnresource.json"() {
        given:
        def input = getClass().getResourceAsStream("/fastlonnresource.json")

        when:
        def result = objectMapper.readValue(input, FastlonnResource.class)
        println(result)

        then:
        result
        result.anvist
        result.periode.start
        result.systemId.identifikatorverdi == "ABC123"
        result.beskrivelse == "Test"
        result.periode.start
        result.prosent == 10000
        result.kontostreng
        result.links.size() == 1
    }

    def "Read Fastlonn from fastlonnresourcelinks.json"() {
        given:
        def input = getClass().getResourceAsStream("/fastlonnresourcelinks.json")

        when:
        def result = objectMapper.readValue(input, Fastlonn.class)
        println(result)

        then:
        thrown(UnrecognizedPropertyException)
    }

    def "Read Fastlonn from fastlonnresourcelinks.json with ObjectMapper config"() {
        given:
        def input = getClass().getResourceAsStream("/fastlonnresourcelinks.json")
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

        when:
        def result = objectMapper.readValue(input, Fastlonn.class)
        println(result)

        then:
        result
        result.anvist
        result.periode.start
        result.systemId.identifikatorverdi == "ABC123"
        result.beskrivelse == "Test"
        result.periode.start
        result.prosent == 10000
        result.kontostreng
    }

    def "Read FastlonnResource from fastlonnresourcelinks.json"() {
        given:
        def input = getClass().getResourceAsStream("/fastlonnresourcelinks.json")

        when:
        def result = objectMapper.readValue(input, FastlonnResource.class)
        println(result)

        then:
        result
        result.anvist
        result.periode.start
        result.systemId.identifikatorverdi == "ABC123"
        result.beskrivelse == "Test"
        result.periode.start
        result.prosent == 10000
        result.kontostreng
        result.links.size() == 2
        result.kontostreng.links.size() == 3
    }

    def "Read FastlonnResources from fastlonnresourceslinks.json"() {
        given:
        def input = getClass().getResourceAsStream("/fastlonnresourceslinks.json")

        when:
        def result = objectMapper.readValue(input, FastlonnResources.class)
        println(result)

        then:
        result
        result.getTotalItems() == 1
        result.links.self.size() == 1
        result.content[0].anvist
        result.content[0].periode.start
        result.content[0].systemId.identifikatorverdi == "ABC123"
        result.content[0].beskrivelse == "Test"
        result.content[0].periode.start
        result.content[0].links.size() == 2
        result.content[0].kontostreng.links.size() == 3
    }
}
