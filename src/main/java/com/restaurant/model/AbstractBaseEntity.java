package com.restaurant.model;

public abstract class AbstractBaseEntity {

    public static final int START_SEQ = 100000;

    protected Integer id;

    public AbstractBaseEntity() {
    }

    public AbstractBaseEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew(){
        return this.id == null;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ":" + id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        // TODO
        if (o == null || !getClass().equals(o.getClass())){
            return false;
        }
        AbstractBaseEntity that = (AbstractBaseEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id;
    }

}
