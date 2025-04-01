package parkinglot.repositories;

import parkinglot.models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {
    private Map<Long, Gate> gateMap;
    private Long id;

    public GateRepository() {
        gateMap = new HashMap<>();
        id = 0L;
    }

    public Gate save(Gate gate) {
        // Update + insert => Upsert
        if(gate.getId() == 0){
            // insert
            id = id + 1;
            gate.setId(id);
            gateMap.put(id, gate);
            return gate;
        }
        gateMap.put(gate.getId(), gate);
        return gate;
    }

    public Optional<Gate> findById(Long gateID){
        if(gateMap.containsKey(gateID)){
            return Optional.of(gateMap.get(gateID));
        }
        return Optional.empty();
    }
}

// Gate Object ->
// Gate status -> open, Operator -> {}, gateType -> entry, gate number -> 1
// 1 -> Gate1
// 2 -> Gate2
// 3 -> Gate3