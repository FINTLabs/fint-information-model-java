package no.fint.model.felles

import no.fint.model.test.utils.JsonSnapshots
import spock.lang.Requires
import spock.lang.Specification

class ModelSpec extends Specification {
    private JsonSnapshots jsonSnapshots

    void setup() {
        jsonSnapshots = new JsonSnapshots(this)
    }

    @Requires({ env.CREATE_SNAPSHOTS })
    def "Create snapshots"() {
        expect:
        jsonSnapshots.create()
    }

    @Requires({ env.VALIDATE_SNAPSHOTS })
    def "Matches snapshots"() {
        expect:
        jsonSnapshots.matchesSnapshots()
        jsonSnapshots.matchesRelationNames()
    }
}
