package no.novari.fint.test.model

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import no.novari.fint.model.utdanning.elev.Klasse
import no.novari.fint.test.model.utils.TestApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.hateoas.Resource
import spock.lang.Specification

@SpringBootTest(classes = TestApplication)
class SpringModelDeserializationSpec extends Specification {

    @Autowired
    private ObjectMapper objectMapper

    def "Read Resource from klasseresource json"() {
        given:
        def input = getClass().getClassLoader().getResourceAsStream("klasseresource.json")

        when:
        def result = objectMapper.readValue(input, new TypeReference<Resource<Klasse>>() {})

        then:
        result
        result.links.size() == 3
        result.content
        result.content.navn == "ABC123"
    }
}
