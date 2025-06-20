import java.util.Arrays;
class Product {
    int productId;
    String productName;
    String category;
    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
    @Override
    public String toString() {
        return productId + " - " + productName + " (" + category + ")";
    }
}
class SearchFunctions {
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }
    public static Product binarySearch(Product[] products, String targetName) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int result = products[mid].productName.compareToIgnoreCase(targetName);

            if (result == 0)
                return products[mid];
            else if (result < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }
}
public class ECommerceSearch {
    public static void main(String[] args) {
        // Create product array
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shampoo", "Beauty"),
            new Product(103, "Smartphone", "Electronics"),
            new Product(104, "Notebook", "Stationery"),
            new Product(105, "Camera", "Photography")
        };
        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts, (a, b) -> a.productName.compareToIgnoreCase(b.productName));
        String searchTarget = "Notebook";
        Product linearResult = SearchFunctions.linearSearch(products, searchTarget);
        System.out.println("🔍 Linear Search Result:");
        System.out.println(linearResult != null ? linearResult : "Product not found.");
        Product binaryResult = SearchFunctions.binarySearch(sortedProducts, searchTarget);
        System.out.println("\n🔍 Binary Search Result:");
        System.out.println(binaryResult != null ? binaryResult : "Product not found.");
    }
}
