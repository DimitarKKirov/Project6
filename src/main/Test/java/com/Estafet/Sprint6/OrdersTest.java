package com.Estafet.Sprint6;

import com.Estafet.CustomExceptions.CustomException;
import com.Estafet.CustomExceptions.UnCheckedException;
import org.junit.*;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class OrdersTest {

    static Orders one;
    static Orders two;
    static Orders tengoku;
    static Orders theMoon;
    static File file;

    @BeforeClass
    public static void beforeClass() throws Exception {
        one = new Orders();
        two = new Orders(2, "Dimitar Kirov", "Dimitar@", "30/07/2020", "Bulgaria/Yambol", 1680, true, "D.D", "3/08/2020");
        tengoku = new Orders(3, "Angel Angelov", new String[]{"feder pillou", "towel", "flip-flop", "Beach umbrella"}, 560, "Angel@", "31/07/2020", "Tengoku", 1, false, "Angel Angelov", "31/07/2020", new long[]{110, 110, 15, 325}, 20, 426, 532, 5);
        theMoon = new Orders(4, 1000, "Delyan Delev", "Delyan@", "31/07/2020", "Sofia", "Estafet", "3/08/2020", 15);
        file = new File("~/Project6/Orders List");

    }

    @Before
    public void setUp() throws Exception {
        Orders.orderList();
    }

    @Test
    public void getBusinessDiscount() {
        assertEquals(tengoku.getBusinessDiscount(), 5);
    }

    @Test
    public void setBusinessDiscount() {
        one.setBusinessDiscount(10);
        assertEquals(one.getBusinessDiscount(), 10);
    }

    @Test
    public void getItemPrice() throws CustomException {
        long sum = 0;
        for (int i = 0; i < tengoku.getItemPrice().length; i++) {
            sum += tengoku.getItemPrice()[i];

        }
        if (sum <= 560) {
            assert true;
        } else {
            throw new CustomException("Getter does not work");
        }
    }

    @Test
    public void setItemPrice() {
    }

    @Test
    public void discountCalc() throws IOException {
        theMoon.priceList();
        theMoon.priceCalc();
        theMoon.discountCalc();
        assertEquals(theMoon.getAmountAfterDiscount(), 167);

    }

    @Test
    public void vatArticles() throws IOException {
        theMoon.priceList();
        theMoon.priceCalc();
        theMoon.discountCalc();
        theMoon.vatArticles();
        assertEquals(theMoon.getAmountAfterVat(), 133);
    }

    @Test
    public void priceList() throws IOException {
        theMoon.priceList();
        assertNotNull(theMoon.getOrderPrice());
    }

    @Test
    public void articlesList() {
        theMoon.articlesList();
        assertNotNull(theMoon.getItems());
    }

    @Test
    public void testToString() {
        assertFalse(theMoon.toString().isEmpty());
    }

    @Test
    public void addOrderToList() {
        Orders.addOrderToList(theMoon);
        for (int i = 0; i < Orders.getListWithOrders().size(); i++) {
            assertTrue(Orders.getListWithOrders().contains(theMoon));
        }

    }

    @Test
    public void orderList() {
        assertNotNull(Orders.getListWithOrders());
    }

    @Test
    public void orderListShow() throws UnCheckedException {
//       assertFalse(Orders.orderListShow().isEmpty());
    }

    @Test
    public void generateZip() {
        Long b= (long) Orders.generateZip();
        assertNotNull(b);

    }

    @Test
    public void accountName() {
        String a=(Orders.accountName());
        assertNotNull(a);
    }

    @Test
    public void randomCity() {
        String a=Orders.randomCity();
        assertNotNull(a);

    }

    @Test
    public void bisDis() {
        Long a=(long)Orders.bisDis();
        assertNotNull(a);

    }

    @Test
    public void listChecker() {
        Orders.addOrderToList(theMoon);

    }

    @Test
    public void listContainOrderNumber() {
    }

    @Test
    public void listToFile() {
    }

    @Test
    public void deleteList() {
    }

    @After
    public void tearDown() throws Exception {

    }

    @AfterClass
    public static void afterClass() throws Exception {

    }
}