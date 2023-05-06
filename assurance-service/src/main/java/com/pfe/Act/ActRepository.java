package com.pfe.Act;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActRepository extends JpaRepository<Act, Integer> {

    Act findByAbrv(String abrv);

}
