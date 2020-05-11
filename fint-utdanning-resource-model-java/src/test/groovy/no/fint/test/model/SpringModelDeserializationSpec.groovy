package no.fint.test.model

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import no.fint.model.utdanning.elev.Basisgruppe
import no.fint.test.model.utils.TestApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.hateoas.Resource
import spock.lang.Specification

@SpringBootTest(classes = TestApplication)
class SpringModelDeserializationSpec extends Specification {

    @Autowired
    private ObjectMapper objectMapper

    def "Read Resource from basisgrupperesource.json"() {
        given:
        def input = getClass().getResourceAsStream("/basisgrupperesource.json")
        
        when:
        def result = objectMapper.readValue(input, new TypeReference<Resource<Basisgruppe>>() {})
        println(result)

        then:
        result
        result.links.size() == 1
        result.content
        result.content.periode.start
        result.content.navn == "ABC123"
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
