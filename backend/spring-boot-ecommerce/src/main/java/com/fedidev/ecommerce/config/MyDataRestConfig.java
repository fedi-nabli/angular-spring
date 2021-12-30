package com.fedidev.ecommerce.config;

import com.fedidev.ecommerce.entity.Product;
import com.fedidev.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

    // disable HTTP methods for Product: PUT, POST, DELETE
    config.getExposureConfiguration()
        .forDomainType(Product.class)
        .withItemExposure((matdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
        .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

    // disable HTTP methods for ProductCategory: PUT, POST, DELETE
    config.getExposureConfiguration()
        .forDomainType(ProductCategory.class)
        .withItemExposure((matdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
        .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
  }
}
