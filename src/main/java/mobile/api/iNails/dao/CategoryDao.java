package mobile.api.iNails.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import mobile.api.iNails.domain.Category;

@Service
public interface CategoryDao {
    public List<Category> findAllCategories();
    public Category findCategory(int categoryID);
    public int createCategory(Category category);
    public int updateCategory(Category category);
    public int deleteCategory(int categoryID);
    
}
