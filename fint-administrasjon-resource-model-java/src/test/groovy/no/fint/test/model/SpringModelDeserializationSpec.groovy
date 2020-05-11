package no.fint.test.model

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import no.fint.model.administrasjon.personal.Fastlonn
import no.fint.model.felles.Person
import no.fint.test.model.utils.TestApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.hateoas.Resource
import org.springframework.hateoas.Resources
import spock.lang.Specification

@SpringBootTest(classes = TestApplication)
class SpringModelDeserializationSpec extends Specification {

    @Autowired
    private ObjectMapper objectMapper

    def "Read Resource from fastlonnresourcelinks.json"() {
        given:
        def input = getClass().getResourceAsStream("/fastlonnresourcelinks.json")
        
        when:
        def result = objectMapper.readValue(input, new TypeReference<Resource<Fastlonn>>() {})
        println(result)

        then:
        result
        result.links.size() == 2
        result.content
        result.content.anvist
        result.content.kontostreng
        result.content.periode.start
        result.content.systemId.identifikatorverdi == "ABC123"
        result.content.beskrivelse == "Test"
        result.content.periode.start
        result.content.prosent == 10000
    }

    /*
    def "Read Resources from personresourceslinks json"() {
        given:
        def input = getClass().getResourceAsStream("/personresourceslinks.json")

        when:
        def result = objectMapper.readValue(input, new TypeReference<Resources<Person>>() {})

        then:
        result
        result.links.size() == 1
        result.content
        result.content.bostedsadresse
        result.content.postadresse
    }
    */
}
