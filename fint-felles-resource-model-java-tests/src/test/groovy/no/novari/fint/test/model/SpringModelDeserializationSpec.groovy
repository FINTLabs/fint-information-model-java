package no.novari.fint.test.model

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import no.novari.fint.model.felles.Person
import no.novari.fint.test.model.utils.TestApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.EntityModel
import spock.lang.Specification

@SpringBootTest(classes = TestApplication)
class SpringModelDeserializationSpec extends Specification {
    @Autowired
    private ObjectMapper objectMapper

    def "Read Resource from personresourcelinks json"() {
        given:
        def input = getClass().getClassLoader().getResourceAsStream("personresourcelinks.json")

        when:
        def result = objectMapper.readValue(input, new TypeReference<EntityModel<Person>>() {})

        then:
        result
        result.links.size() == 2
        result.content
        result.content.bostedsadresse
        result.content.postadresse
    }

    def "Read Resources from personresourceslinks json"() {
        given:
        def input = getClass().getClassLoader().getResourceAsStream("personresourceslinks.json")

        when:
        def result = objectMapper.readValue(input, new TypeReference<CollectionModel<Person>>() {})

        then:
        result
        result.links.size() == 1
        result.content.size() == 1
        result.content[0].bostedsadresse.adresselinje[0] == "Storgata 12"
        result.content[0].navn.fornavn == "Tore"
        result.content[0].navn.etternavn == "Test"
    }
}
