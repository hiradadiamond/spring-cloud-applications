package miu.edu.cs.cs544.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StateProvince {

	@EqualsAndHashCode.Include
	private Long id;
	
	private String stateProvinceCode;
	
	private String name;
	
}
