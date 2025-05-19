package no.fint.test.model

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException
import no.fint.model.felles.Person
import no.fint.model.resource.felles.KontaktpersonResource
import no.fint.model.resource.felles.PersonResource
import no.fint.model.resource.felles.PersonResources

//import no.fint.model.resource.felles.PersonResources
import spock.lang.Specification

class ModelDeserializationSpec extends Specification {
    def objectMapper

    void setup() {
        objectMapper = new ObjectMapper()
    }

    def "Read Person from person.json"() {
        given:
        def input = getClass().getResourceAsStream("/person.json")

        when:
        def result = objectMapper.readValue(input, Person.class)
        println(result)

        then:
        result
    }

    def "Read PersonResource from person.json"() {
        given:
        def input = getClass().getResourceAsStream("/person.json")

        when:
        def result = objectMapper.readValue(input, PersonResource.class)
        println(result)

        then:
        result
    }

    def "Read Person from personresource.json"() {
        given:
        def input = getClass().getResourceAsStream("/personresource.json")

        when:
        def result = objectMapper.readValue(input, Person.class)
        println(result)

        then:
        thrown(UnrecognizedPropertyException)
    }

    def "Read Person from personresource.json with ObjectMapper config"() {
        given:
        def input = getClass().getResourceAsStream("/personresource.json")
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        when:
        def result = objectMapper.readValue(input, Person.class)
        println(result)

        then:
        result
    }

    def "Read PersonResource from personresource.json"() {
        given:
        def input = getClass().getResourceAsStream("/personresource.json")

        when:
        def result = objectMapper.readValue(input, PersonResource.class)
        println(result)

        then:
        result
        result.links.size() == 3
    }

    def "Read Person from personresourcelinks.json"() {
        given:
        def input = getClass().getResourceAsStream("/personresourcelinks.json")

        when:
        def result = objectMapper.readValue(input, Person.class)
        println(result)

        then:
        thrown(UnrecognizedPropertyException)
    }

    def "Read Person from personresourcelinks.json with ObjectMapper config"() {
        given:
        def input = getClass().getResourceAsStream("/personresourcelinks.json")
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        when:
        def result = objectMapper.readValue(input, Person.class)
        println(result)

        then:
        result
    }

    def "Read PersonResource from personresourcelinks.json"() {
        given:
        def input = getClass().getResourceAsStream("/personresourcelinks.json")

        when:
        def result = objectMapper.readValue(input, PersonResource.class)
        println(result)

        then:
        result
        result.bostedsadresse
        result.postadresse
    }

    def "Read PersonResources from personresourceslinks.json"() {
        given:
        def input = getClass().getResourceAsStream("/personresourceslinks.json")

        when:
        def result = objectMapper.readValue(input, PersonResources.class)
        println(result)

        then:
        result
        result.getTotalItems() == 1
        result.links.self.size() == 1
        result.content[0].bostedsadresse
        result.content[0].postadresse
    }

    def "Read KontaktpersonResource from kontaktpersonresource.json"() {
        given:
        def input = getClass().getResourceAsStream("/kontaktpersonresource.json")

        when:
        def result = objectMapper.readValue(input, KontaktpersonResource)
        println(result)

        then:
        result
        result instanceof KontaktpersonResource
        result.links.size() == 2
    }
}
