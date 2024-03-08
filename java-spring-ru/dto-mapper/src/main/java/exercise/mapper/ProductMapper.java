package exercise.mapper;

// BEGIN

import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.model.Product;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class ProductMapper {
    @Mapping(target = "name", source = "title")
    @Mapping(target = "cost", source = "price")
    @Mapping(target = "barcode", source = "vendorCode")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    public abstract Product map(ProductCreateDTO dto);


    @Mapping(target = "cost", source = "price")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "barcode", ignore = true)
    public abstract void update(ProductUpdateDTO dto, @MappingTarget Product model);

    @Mapping(target = "title", source = "name") // or @InheritInverseConfiguration
    @Mapping(target = "vendorCode", source = "barcode")
    @Mapping(target = "price", source = "cost")
    public abstract ProductDTO map(Product model);
}
// END
