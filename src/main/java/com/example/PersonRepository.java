package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alejandro Duarte
 * @see <a href="https://github.com/alejandro-du/lazy-loading-spring-demo">https://github.com/alejandro-du/lazy-loading-spring-demo</a>
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
