package pl.dn.schoolClassOrganization.occupationalGroup;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OccupationalGroupDao extends CrudRepository<OccupationalGroup, Long>{
	
	public OccupationalGroup findById(long id);
	public List<OccupationalGroup> findAll();
	public List<OccupationalGroup> findBySchoolClassId(long id);
	public List<OccupationalGroup> findByTeacherId(long id);
	public List<OccupationalGroup> findBySchoolClassIdAndTeacherId(long schoolClassId, long teacherId);
	public List<OccupationalGroup> findBySchoolSubjectId(long id);
	
	public void deleteById(long id);
	

}
