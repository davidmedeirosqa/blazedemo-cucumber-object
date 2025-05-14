Feature: Comprar passagem
    Escolher e comprar passagem aereas

  Scenario Outline: Comprar com sucesso 
    Given que acesso o site "https://www.blazedemo.com/" 
    When seleciono a <origem> e <destino> 
    And clico no botao Find Flights 
    Then visualiza a lista de voos 
    When clico no <ordem_do_voo>

    Examples:
      | origem     | destino  | ordem_do_voo |
      | "Portland" | "Dublin" | 2            |
      | "Paris"    | "Berlin" | 5            |