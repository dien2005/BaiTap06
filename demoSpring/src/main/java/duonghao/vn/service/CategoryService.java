package duonghao.vn.service;
import duonghao.vn.model.Category;
import duonghao.vn.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

    public Page<Category> listAll(String keyword, Pageable pageable) {
        if (keyword != null && !keyword.isEmpty()) {
            return repo.findByNameContainingIgnoreCase(keyword, pageable);
        }
        return repo.findAll(pageable);
    }

    public Category save(Category category) {
        return repo.save(category);
    }

    public Category get(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
