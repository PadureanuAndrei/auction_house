package project.models.products.exceptions;

import project.models.products.Product;

public class UndefinedProductTypeException extends RuntimeException {

    public UndefinedProductTypeException(Class<? extends Product> classType) {
        super("Class '" + classType + "' is not a valid Product");
    }
}
