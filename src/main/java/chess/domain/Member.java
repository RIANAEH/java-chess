package chess.domain;

public class Member {

    private final String id;
    private final String name;

    public Member(final String id, final String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
