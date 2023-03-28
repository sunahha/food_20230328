package food.infra;

import food.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "menuInformations",
    path = "menuInformations"
)
public interface MenuInformationRepository
    extends PagingAndSortingRepository<MenuInformation, Long> {}
