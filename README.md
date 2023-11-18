# Lab7 Spring Boot Project

## Giới Thiệu
Dự án Lab7 là một ứng dụng Spring Boot, được thiết kế để quản lý thông tin về khách hàng, nhân viên, đơn hàng, sản phẩm, và chi tiết đơn hàng. Dự án được chia thành các package chính như sau:

- **entity**: Chứa các class đại diện cho các thực thể trong hệ thống, bao gồm `Customer`, `Employee`, `Order`, `OrderDetail`, `Product`, `ProductImage`, `ProductPrice`.

- **dao**: Chứa các lớp Data Access Object (DAO) đảm nhiệm truy cập và thao tác dữ liệu trong cơ sở dữ liệu. Các lớp DAO bao gồm `CustomerDao` (chứa hàm `logIn`), `PostDao` (chứa các hàm `logIn`, `add`, `update`, `delete`, `activeEmp`, `get`, `getAllEmpList`, `getAll`), `OrderDao` (chứa hàm `add`, `getOrderByDate`, `getOrderByMonth`, `getOrderByEmployeeForMonth`, `getLastOrder`), `OrderDetailDao` (chứa các hàm `calcTotalPrice`, `getOrderDetailByOrderID`), `ProductDao` (chứa các hàm `add`, `update`, `delete`, `activeProduct`, `get`, `getAllProductList`, `getProductPricePathsOfProduct`, `getProductPricePaths`, `getAll`).

- **controllers**: Chứa các lớp Controller, bao gồm `CustomerController`, `EmployeeController`, `OrderController`, `ProductController`.

- **convert**: Chứa các lớp chuyển đổi dữ liệu, bao gồm `PostForm`, `UserForm`.

## Cấu Trúc Thư Mục
```
|-- src
|   |-- main
|       |-- java
|           |-- vn.edu.iuh.fit
|               |-- controllers
|               |-- convert
|               |-- dao
|               |-- entity
|               |-- Lab7Application.java
|-- src
|   |-- main
|       |-- resources
|           |-- templates
|           |   |-- [các file giao diện]
|           |-- application.properties
```

## Cấu Hình Database
File `application.properties` trong thư mục `resources` chứa cấu hình kết nối database:

```properties
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.datasource.url=jdbc:mariadb://localhost:3306/week7
spring.datasource.username=root
spring.datasource.password=sapass
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8083
spring.application.name=lab7
spring.jpa.hibernate.naming.implicit-strategy=org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
```

## Lab7Application
File `Lab7Application.java` chứa hàm `main` để chạy ứng dụng Spring Boot và thực hiện các demo với các DAO:

```java
package vn.edu.iuh.fit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import vn.edu.iuh.fit.dao.EmployeeDao;
import vn.edu.iuh.fit.dao.OrderDao;
import vn.edu.iuh.fit.dao.OrderDetailDao;
import vn.edu.iuh.fit.dao.ProductDao;
import vn.edu.iuh.fit.entity.*;

import java.time.LocalDateTime;

@SpringBootApplication
public class Lab7Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Lab7Application.class, args);
        EmployeeDao employeeDao = context.getBean(EmployeeDao.class);
        OrderDao orderDao = context.getBean(OrderDao.class);
        OrderDetailDao orderDetailDao = context.getBean(OrderDetailDao.class);
        ProductDao productDao = context.getBean(ProductDao.class);

        // Các ví dụ demo sử dụng DAO
        // ...

        // Ví dụ: Lấy danh sách giá của sản phẩm
        productDao.getProductPricePaths().forEach(pp -> System.out.println(pp.toString()));
    }

}

```

## Hướng Dẫn Sử Dụng
1. Chắc chắn bạn đã cấu hình đúng kết nối database trong file `application.properties`.
2. Chạy ứng dụng bằng cách chạy hàm `main` trong file `Lab7Application.java`.
3. Kiểm tra console để xem kết quả các demo với các DAO đã được thực hiện.
4. Truy cập http://localhost:8083/ bằng trình duyệt web của bạn 

## Lưu ý

- Trước khi chạy ứng dụng, đảm bảo rằng đã cấu hình đúng kết nối database trong file `application.properties`.

## Thư viện và Công nghệ sử dụng

- Spring Boot
- MariaDB
- Thymeleaf (được sử dụng trong thư mục "templates")

## Đóng góp

Nếu bạn muốn đóng góp vào dự án Lab 7 Spring Boot, bạn có thể thực hiện các bước sau:

1. Fork dự án trên [GitHub](https://github.com/ThuyTien2111/www_lab7).
2. Tạo một nhánh mới cho các tính năng hoặc sửa đổi bạn muốn thêm vào.
3. Thực hiện các thay đổi và thêm các testcase liên quan.
4. Tạo một pull request để xem xét và hợp nhất thay đổi của bạn vào dự án gốc.

Tôi hoan nghênh sự đóng góp từ cộng đồng để cải thiện dự án này.

## Tác giả

- [Thuy Tien](https://github.com/ThuyTien2111): Sinh viên năm cuối đang học tập tại IUH (Đại học Công nghiệp TPHCM).

## Hình ảnh sản phẩm
[Imgur](https://i.imgur.com/uUPuTzY.png)

[Imgur](https://i.imgur.com/B57eNrS.png)

[Imgur](https://i.imgur.com/bt2ByCT.png)

[Imgur](https://i.imgur.com/Vx5s7FJ.png)

[Imgur](https://i.imgur.com/NbfMmmc.png)

[Imgur](https://i.imgur.com/WDghNV2.png)

[Imgur](https://i.imgur.com/jTTFS3N.png)

[Imgur](https://i.imgur.com/nUj04zc.png)

[Imgur](https://i.imgur.com/IB17HR9.png)

[Imgur](https://i.imgur.com/nXsRh5w.png)

[Imgur](https://i.imgur.com/FJM6sYR.png)

[Imgur](https://i.imgur.com/AA6RnqH.png)


