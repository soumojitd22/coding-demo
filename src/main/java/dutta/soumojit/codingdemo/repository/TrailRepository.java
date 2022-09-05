package dutta.soumojit.codingdemo.repository;

import dutta.soumojit.codingdemo.entity.Trail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrailRepository extends JpaRepository<Trail, Integer> {
}
