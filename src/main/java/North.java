public record North() implements Direction{
    @Override
    public Direction turnLeft() {
        return new West();
    }
}
