package miu.edu.cs.cs544.domain;

import lombok.*;

import java.util.List;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CountryRegion {

	private String id;
	
	private String name;

	private List<StateProvince> states;
	
}
