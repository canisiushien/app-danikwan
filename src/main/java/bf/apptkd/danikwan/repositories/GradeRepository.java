package bf.apptkd.danikwan.repositories;

import bf.apptkd.danikwan.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Canisius <canisiushien@gmail.com>
 * @created 14/07/2025 at 16:05
 */
public interface GradeRepository extends JpaRepository<Grade, Long> {
}
