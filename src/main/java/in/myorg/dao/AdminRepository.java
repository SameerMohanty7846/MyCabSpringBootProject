package in.myorg.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.myorg.entity.Admin;
import jakarta.transaction.Transactional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	Optional<Admin> findByUsername(String username);

	@Modifying
	@Transactional
	@Query(value = "update admin set username=:newusername, password=:newpassword WHERE username=:oldusername", nativeQuery = true)

	int updateCredentials(@Param("newusername") String newusername,
			              @Param("newpassword") String newpassword,
			              @Param("oldusername") String oldusername);

}
