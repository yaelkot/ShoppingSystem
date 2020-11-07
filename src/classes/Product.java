package classes;

import java.util.ArrayList;

public class Product {

    private String id; //the usual filed that given
    private String name;
    private int price;  //maybe need to be added
    private Supplier supplier;
    private ArrayList<LineItem> listLineItems;
    private PremiumAccount premiumAccount;

    public Product(String id, String name, int price, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.supplier = supplier;
        this.listLineItems = new ArrayList<LineItem>();
        this.premiumAccount = null;
    }

    //setters and getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public ArrayList<LineItem> getListLineItems() {
        return listLineItems;
    }

    public PremiumAccount getPremiumAccount() {
        return premiumAccount;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public void UpdateListLineItem(LineItem lineItem) {
        listLineItems.add(lineItem);
    }

    public void setPremiumAccount(PremiumAccount premiumAccount) {
        this.premiumAccount = premiumAccount;
    }

    //delete functions
    public void DeleteListLineItem(LineItem lineItem) {
        listLineItems.remove(lineItem);
    }

    public void Delete()
    {
        for (LineItem lItem:listLineItems)
            lItem.Delete();
        listLineItems = null;
        this.supplier.DeleteFromHashProduct(id);
        this.supplier = null;
        if(this.premiumAccount != null){
            this.premiumAccount.DeleteFromHashProduct(id);
            this.premiumAccount = null;
        }
    }

    //prints
    @Override
    public String toString() {
        return "Product";
    }

    public void print() {
        System.out.println("Object's id: " + this.id + ", object's name: " + this.name+ ", object's price: " + this.price);
    }

    public void printInfo(){
        System.out.println("Object connecting: ");
        System.out.println("Supplier");
        if(this.premiumAccount != null)
            System.out.println(", PremiumAccount");
        if(!this.listLineItems.isEmpty())
            System.out.println(", LineItems");
    }
}