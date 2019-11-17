CREATE OR REPLACE FUNCTION aft_delete_item()
  RETURNS trigger AS
$$
BEGIN
	UPDATE compra SET total = (SELECT SUM(preco) FROM itens_compra WHERE id_compra = OLD.id_compra)
	WHERE id_compra = OLD.id_compra;
RETURN NEW;
END;

$$
LANGUAGE 'plpgsql';

CREATE TRIGGER update_total_compra
  AFTER DELETE
  ON itens_compra
  FOR EACH ROW
  EXECUTE PROCEDURE aft_delete_item();


CREATE OR REPLACE FUNCTION aft_delete_or_update_compra()
  RETURNS trigger AS
$$
BEGIN
	UPDATE conta SET total = (SELECT SUM(total) FROM compra WHERE id_conta = OLD.id_conta)
	WHERE id_conta = OLD.id_conta;
RETURN NEW;
END;

$$
LANGUAGE 'plpgsql';

CREATE TRIGGER update_total_conta
  AFTER DELETE OR UPDATE
  ON compra
  FOR EACH ROW
  EXECUTE PROCEDURE aft_delete_or_update_compra();
