package br.com.onparty.rwsonpartymiddleware.service.impl;

import br.com.onparty.rwsonpartymiddleware.dto.SupplierDTO;
import br.com.onparty.rwsonpartymiddleware.client.RestClient;
import br.com.onparty.rwsonpartymiddleware.service.SupplierService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    private String server = "https://rws-onparty-supplier.herokuapp.com/v1/suppliers/";

    @Override
    public List<SupplierDTO> findAll() {
        RestClient restClient = new RestClient(server);
        String json = restClient.get("");
        Gson gson = new Gson();
        List<SupplierDTO> supplierDTOList = gson.fromJson(json, new TypeToken<List<SupplierDTO>>() {}.getType());
        return supplierDTOList;
    }

    @Override
    public SupplierDTO findById(Integer id) {
        RestClient restClient = new RestClient(server);
        String json = restClient.get(id.toString());
        Gson gson = new Gson();
        SupplierDTO supplierDTO = gson.fromJson(json, new TypeToken<SupplierDTO>() {}.getType());
        return supplierDTO;
    }

    @Override
    public SupplierDTO findByCnpj(String cnpj) {
        RestClient restClient = new RestClient(server);
        String json = restClient.get("cnpj/" + cnpj);
        Gson gson = new Gson();
        SupplierDTO supplierDTO = gson.fromJson(json, new TypeToken<SupplierDTO>() {}.getType());
        return supplierDTO;
    }

    @Override
    public SupplierDTO create(SupplierDTO supplierDTO) {
        RestClient restClient = new RestClient(server);
        Gson gson = new Gson();
        String json = gson.toJson(supplierDTO);
        String response = restClient.post(json);
        SupplierDTO responseDto = gson.fromJson(response, new TypeToken<SupplierDTO>() {}.getType());
        return responseDto;
    }

    @Override
    public SupplierDTO update(SupplierDTO supplierDTO) {
        RestClient restClient = new RestClient(server);
        Gson gson = new Gson();
        String json = gson.toJson(supplierDTO);
        String response = restClient.put(json);
        SupplierDTO responseDto = gson.fromJson(response, new TypeToken<SupplierDTO>() {}.getType());
        return responseDto;
    }

    @Override
    public void delete(Integer id) {
        RestClient restClient = new RestClient(server);
        restClient.delete(id.toString());
    }
}
