public record South() implements Direction{
    @Override
    public Direction turnLeft() {
        return new East();
    }
}
