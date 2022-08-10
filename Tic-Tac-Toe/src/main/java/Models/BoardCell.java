package Models;

import Command.Symbol;

public class BoardCell {
    public Integer row;
    public Integer col;
    public Symbol symbol = Symbol.E;

    public BoardCell() {

    }
    public BoardCell(int row, int col, Symbol symbol) {
        this.row = row;
        this.col = col;
        this.symbol = symbol;
    }
    public BoardCell(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
