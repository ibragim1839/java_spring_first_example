package ibragim.project.core.orm.repositories;

import ibragim.project.core.orm.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.nio.file.LinkOption;
@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
