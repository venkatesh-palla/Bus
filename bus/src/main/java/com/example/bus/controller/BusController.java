package com.example.bus.controller;

import com.example.bus.api.response.bus.ConnectedBusApiResponse;
import com.example.bus.entity.BusType;
import com.example.bus.api.request.bus.BusRequest;
import com.example.bus.api.response.bus.BusResponse;
import com.example.bus.service.bus.BusService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


@RestController
@RequestMapping("/Bus")
public class BusController {

    @Autowired
    BusService busService;


    /**
     * Endpoint to create a new bus.
     *
     * @param busRequest The request body containing bus details.
     * @return BusResponse containing details of the created bus.
     */
    @PostMapping("/create")
    @Operation(summary = "Create a new bus",
            description = "Creates a new bus with the provided details.")
    public BusResponse create(@RequestBody BusRequest busRequest) {
        return busService.create(busRequest);
    }


    /**
     * Endpoint to update an existing bus.
     *
     * @param busRequest The request body containing updated bus details.
     * @return BusResponse containing details of the updated bus.
     */
    @PutMapping("/update")
    @Operation(summary = "Update an existing bus",
            description = "Updates an existing bus with the provided details.")
    public BusResponse update(@RequestBody BusRequest busRequest) {
        return busService.update(busRequest);
    }


    /**
     * Endpoint to delete a bus by its ID.
     *
     * @param busId The ID of the bus to delete.
     */
    @DeleteMapping("/delete/{busId}")
    @Operation(summary = "Delete a bus", description = "Deletes a bus by its ID.")
    public void delete(@PathVariable String busId) {
        busService.delete(busId);
    }


    /**
     * Endpoint to retrieve details of all buses.
     *
     * @return List of BusResponse containing details of all buses.
     */
    @GetMapping("/getAllBuses")
    @Operation(summary = "Get all buses", description = "Retrieves details of all buses")
    public List<BusResponse> getBusData() {
        return busService.getBuses();
    }


    /**
     * Endpoint to retrieve buses by their name.
     *
     * @param busName The name of the bus to retrieve.
     * @return List of BusResponse containing details of buses with the specified name.
     */
    @GetMapping("/getBusByName/{busName}")
    @Operation(summary = "Get buses by name",
            description = "Retrieves details of buses with the specified name.")
    public List<BusResponse> getBusByName(@PathVariable String busName) {
        return busService.getBusByName(busName);
    }


    /**
     * Endpoint to retrieve buses by source, destination, and date.
     *
     * @param source      The source of the bus route.
     * @param destination The destination of the bus route.
     * @param date        The date of the journey.
     * @return List of BusResponse containing details of buses matching the criteria.
     */
    @GetMapping("/getBusBySourceAndDestinationByTime/{source}/{destination}/{date}")
    @Operation(summary = "Get buses by source, destination, and date",
            description = "Retrieves details of buses by source, destination, and date.")
    public List<BusResponse> getBusBySourceAndDestinationByTime(@PathVariable String source,
                                                                @PathVariable String destination,
                                                                @PathVariable Date date) {
        return busService.getBusBySourceAndDestinationByTime(source, destination, date);
    }


    /**
     * Endpoint to retrieve buses by departure time.
     *
     * @param time The departure time of the buses.
     * @return List of BusResponse containing details of buses departing at the specified time.
     */
    @GetMapping("/getBusBytime/{time}")
    @Operation(summary = "Get buses by departure time",
            description = "Retrieves details of buses departing at the specified time.")
    public List<BusResponse> getBusByTime(@PathVariable Timestamp time) {
        return busService.getBusByTime(time);
    }


    /**
     * Endpoint to retrieve buses by bus type.
     *
     * @param busType The type of bus to retrieve (e.g., AC, Non-AC).
     * @return List of BusResponse containing details of buses matching the specified type.
     */
    @GetMapping("/busType/{busType}")
    @Operation(summary = "Get buses by type",
            description = "Retrieves details of buses by bus type (e.g., AC, Non-AC).")
    public List<BusResponse> busType(@PathVariable BusType busType) {
        return busService.busType(busType);
    }


    /**
     * Endpoint to retrieve connected buses based on their source and destination.
     *
     * @param firstBusSource       The source of the first bus.
     * @param secondBusDestination The destination of the second bus.
     * @return List of ConnectedBusApiResponse containing details of connected buses.
     */
    @GetMapping("/connectedBuses/{firstBusSource}/{secondBusDestination}")
    @Operation(summary = "Get connected buses",
            description = "Retrieves details of connected buses based on their source and destination.")
    public List<ConnectedBusApiResponse> connectedBuses(@PathVariable String firstBusSource,
                                                        @PathVariable String secondBusDestination) {
        return busService.getConnectedBuses(firstBusSource, secondBusDestination);
    }

    @GetMapping("/getBusByBusId/{busId}")
    @Operation(summary = "Get bus by ID", description = "Retrieves details of a bus by its ID.")
    public BusResponse getBusByBusId(@PathVariable String busId) {
        return busService.getBusByBusId(busId);
    }

}
