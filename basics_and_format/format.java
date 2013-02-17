DecimalFormat df = new DecimalFormat();
df.setMinimumFractionDigits(x);
df.setMaximumFractionDigits(x);
DecimalFormatSymbols symbols = new DecimalFormatSymbols();
symbols.setDecimalSeparator(',');
String respuesta = df.format(numero);
System.out.println(respuesta);