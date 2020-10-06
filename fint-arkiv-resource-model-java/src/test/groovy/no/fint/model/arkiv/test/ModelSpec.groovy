package no.fint.model.arkiv.test

import com.fasterxml.jackson.databind.ObjectMapper
import no.fint.model.resource.arkiv.kulturminnevern.TilskuddFartoyResource
import spock.lang.Specification

class ModelSpec extends Specification {

    def mapper = new ObjectMapper()

    def 'Able to deserialize tilskuddfartoy.json'() {
        when:
        def resource = mapper.readValue(getClass().getResourceAsStream('/tilskuddfartoy.json'), TilskuddFartoyResource)

        then:
        resource.tittel == 'Tilskudd - AWQR - Ternen - 232291-0 - 35 - FINT Test #1'
        resource.journalpost.any {it.dokumentbeskrivelse.any {it.tittel == 'Tomt arkivskap'}}
        resource.journalpost.size() == 23
    }
}
