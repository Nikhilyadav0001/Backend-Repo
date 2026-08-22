package nikhil.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import nikhil.bean.StockApi;

public interface IStockRepository extends JpaRepository<StockApi, Integer>{

}
