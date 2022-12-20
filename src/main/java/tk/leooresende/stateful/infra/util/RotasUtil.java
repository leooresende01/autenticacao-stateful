package tk.leooresende.stateful.infra.util;

import java.util.Arrays;
import java.util.List;

import tk.leooresende.stateful.infra.util.values.RotasPath;

public class RotasUtil {
	public static String[] getRotasProtegidas() {
		List<String> listaDeRotasProtegidas = Arrays.asList(RotasPath.DASHBOARD.getPath());
		return RotasUtil.mapearListaParaArray(listaDeRotasProtegidas);
	}

	public static String[] getRotasSemProtecao() {
		List<String> listaDeRotasProtegidas = Arrays.asList(RotasPath.CADASTRO.getPath(), RotasPath.ROOT_PATH.getPath(),
				RotasPath.LOGIN.getPath());
		return RotasUtil.mapearListaParaArray(listaDeRotasProtegidas);
	}

	private static String[] mapearListaParaArray(List<String> listaDeRotas) {
		String[] listaDeRotasEmArray = new String[listaDeRotas.size()];
		for (int i = 0; i < listaDeRotas.size(); i++) {
			listaDeRotasEmArray[i] = listaDeRotas.get(i);
		}
		return listaDeRotasEmArray;
	}
}
