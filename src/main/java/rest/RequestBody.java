package rest;

public class RequestBody {
    private final DataType type;
    private final Object object;

    public RequestBody(DataType type, Object object) {
        this.type = type;
        this.object = object;
    }

    public DataType getType() {
        return type;
    }

    public Object getObject() {
        return object;
    }
}
