public record West() implements Direction{
    @Override
    public Direction turnLeft() {
        return new South();
    }
}
