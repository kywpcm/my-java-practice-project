package entity;

import java.math.BigDecimal;
import java.util.Objects;

// 클래스 자체가 비즈니스 키인 경우
public class Product {

	// (마치 DB의 복합키..)
	private int id; 			  // 비즈니스 PK라고 하자.
	private String name;		  // 비즈니스 PK라고 하자.
	private BigDecimal price; // 비즈니스 PK라고 하자.
	
	/**
	 * @param id
	 * @param name
	 * @param price
	 */
	public Product(int id, String name, BigDecimal price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]\n";
	}

	@Override
	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + id;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + ((price == null) ? 0 : price.hashCode());
//		return result;

		// Objects 클래스 java 1.7부터 추가
		return Objects.hash(id, name, price);
	}

	@Override
	public boolean equals(final Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Product other = (Product) obj;
//		if (id != other.id)
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		if (price == null) {
//			if (other.price != null)
//				return false;
//		} else if (!price.equals(other.price))
//			return false;
//		return true;
		
		// Objects 클래스 java 1.7부터 추가
		if (this == obj) return true;
		if (!(obj instanceof Product)) return false;
		final Product that = (Product) obj;
		return Objects.equals(this.id, that.id) &&
				Objects.equals(this.name, that.name) &&
				Objects.equals(this.price, that.price);
	}
	
}
