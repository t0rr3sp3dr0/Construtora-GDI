package systems.singularity.buildware.models;

public class Provider {
    private int id;
    private String name;
    private String cnpj;
    private BankAccount bankAccount;
    private String email;

    public Provider() {
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCNPJ() {
        return cnpj;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCNPJ(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Provider id(int id) {
        this.id = id;
        return this;
    }

    public Provider name(String name) {
        this.name = name;
        return this;
    }

    public Provider cnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }
    public Provider bankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }

    public Provider email(String email) {
        this.email = email;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Provider)) return false;

        Provider provider = (Provider) o;

        return getId() == provider.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }
}
