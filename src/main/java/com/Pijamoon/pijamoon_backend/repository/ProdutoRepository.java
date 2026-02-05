package com.Pijamoon.pijamoon_backend.repository;

import com.Pijamoon.pijamoon_backend.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel,Long> {
}
