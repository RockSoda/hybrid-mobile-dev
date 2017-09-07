package week4_1;

public class Customer {

    public String name;
    public boolean member;
    public String memberType;
    Customer(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String type) {
        memberType = type;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
