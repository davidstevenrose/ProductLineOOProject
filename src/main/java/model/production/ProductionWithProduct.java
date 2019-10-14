package model.production;

import java.time.LocalDateTime;
import misc.Util;
import model.Product;

public class ProductionWithProduct extends Production {

  private Product product;
  private String productSimpleName;

  /**
   * Creates a record of production and attaches a product with it.
   *
   * @param productionId This production's id.
   * @param quantity The number of items produced
   * @param manufacturedOn The date and time this production was processed.
   * @param product The product produced.
   */
  public ProductionWithProduct(int productionId, int quantity, LocalDateTime manufacturedOn,
      Product product) {
    super(product.getId(), quantity, "", manufacturedOn);
    this.productionId = productionId;
    this.product = product;
    this.productSimpleName = product.getSimpleName();
  }

  /**
   * Creates a Production without a productionId for being generated by the database.
   * @see #ProductionWithProduct(int, int, LocalDateTime, Product)
   */
  public ProductionWithProduct(Product product, int quantity, LocalDateTime manufacturedOn) {
    super(product.getId(), quantity, manufacturedOn);
    this.productionId = 0;
    this.product = product;
    this.productSimpleName = product.getSimpleName();
  }

  /**
   * Creates a Production record and attaches a Product to it.
   * @param productionId The id of this production
   * @param quantity The number of products produced
   * @param serialNumber The serial number of this production
   * @param manufacturedOn The date that this production was processed
   * @param product The product that was produced
   */
  public ProductionWithProduct(int productionId, int quantity,
      String serialNumber, LocalDateTime manufacturedOn, Product product) {
    super(productionId, product.getId(), quantity, serialNumber, manufacturedOn);

    setProduct(product);
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
    this.productSimpleName = product.getSimpleName();
  }

  /**
   * Generates a serial number for a product.
   *
   * @param uuid The uuid that will be assigned to this production. The next
   */
  public void generateSerialNumber(int uuid) {
    String manufacturer = product.getManufacturer();
    String manufacturerPrefix =
        manufacturer.length() > 3 ? manufacturer.substring(0, 3) : manufacturer;
    String paddedUuid = Util.padLeft(String.valueOf(uuid), 5, "0");
    String serialNum = manufacturerPrefix + product.getItemType().getCode() + paddedUuid;

    setSerialNumber(serialNum);
  }

  public String getProductSimpleName() {
    return productSimpleName;
  }
}
