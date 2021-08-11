package com.nk.model;

public class Product {
String productid;
String productname;
private String base64Image;

public String getBase64Image() {
    return base64Image;
}

public void setBase64Image(String base64Image) {
    this.base64Image = base64Image;
}

public String getProductid() {
	return productid;
}

public void setProductid(String productid) {
	this.productid = productid;
}

public String getProductname() {
	return productname;
}

public void setProductname(String productname) {
	this.productname = productname;
}


}
