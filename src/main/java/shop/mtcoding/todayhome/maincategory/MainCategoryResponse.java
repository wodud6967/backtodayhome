package shop.mtcoding.todayhome.maincategory;

import lombok.Data;
import shop.mtcoding.todayhome.subcategory.SubCategory;

import java.util.ArrayList;
import java.util.List;

public class MainCategoryResponse {

    @Data
    public static class MainCategoryDTO{
        private Integer id;
        private String name;
        private List<SubCategoryDTO> subCategoryDTOS = new ArrayList<>();

        public MainCategoryDTO(MainCategory mainCategory){
            this.id = mainCategory.getId();
            this.name=mainCategory.getName();

            if(mainCategory.getSubCategory() != null){
                for(SubCategory subCategory : mainCategory.getSubCategory()){
                    this.subCategoryDTOS.add(new SubCategoryDTO(subCategory));
                }
            }
        }

    }

    @Data
    public  static class SubCategoryDTO{
        private Integer id;
        private String name;

        public SubCategoryDTO(SubCategory subCategory){
            this.id = subCategory.getId();
            this.name= subCategory.getName();
        }
    }
}
